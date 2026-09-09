package MixOfAll;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class q1{

    static final double L = 10.0;     // cube edge
    static final double EPS = 1e-9;

    static class Pt {
        double x, y, z;
        Pt(double x, double y, double z) { this.x = x; this.y = y; this.z = z; }
    }

    // ---- rounding (half-up) to 2 decimals per leg ----
    static double round2HalfUp(double v) {
        return new BigDecimal(Double.toString(v)).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    // ---- identify which face a point lies on ----
    // 'T' (z=10), 'L' (x=0), 'R' (x=10), 'F' (y=0), 'B' (y=10)
    static char faceOf(Pt p) {
        if (Math.abs(p.z - L) < EPS) return 'T';
        if (Math.abs(p.x - 0.0) < EPS) return 'L';
        if (Math.abs(p.x - L)   < EPS) return 'R';
        if (Math.abs(p.y - 0.0) < EPS) return 'F';
        if (Math.abs(p.y - L)   < EPS) return 'B';
        throw new IllegalArgumentException("Point not on an allowed face (or on an edge).");
    }

    // ---- planar chord length within the same face ----
    static double chordSameFace(Pt a, Pt b, char face) {
        if (face == 'T') {
            return hypot(a.x - b.x, a.y - b.y);
        } else if (face == 'L' || face == 'R') {
            return hypot(a.y - b.y, a.z - b.z);
        } else if (face == 'F' || face == 'B') {
            return hypot(a.x - b.x, a.z - b.z);
        }
        throw new IllegalArgumentException("Unknown face");
    }

    // ---- rotate so chosen root face becomes Top (z' = L) ----
    static Pt rotateToRootTop(Pt p, char root) {
        double x = p.x, y = p.y, z = p.z;
        switch (root) {
            case 'T': return new Pt(x,         y,         z);
            case 'F': return new Pt(x,         z,         L - y);
            case 'B': return new Pt(x,         L - z,     y);
            case 'L': return new Pt(y,         z,         L - x);
            case 'R': return new Pt(L - y,     z,         x);
            default: throw new IllegalArgumentException("Invalid root");
        }
    }

    // ---- map (already rotated) point into the Top-root 2D net (no bottom) ----
    // returns double[]{u,v} or null if not on the faces of this net
    static double[] mapToTopNet2D(Pt pr) {
        double x = pr.x, y = pr.y, z = pr.z;
        if (Math.abs(z - L) < EPS)   return new double[]{x, y};                 // Top
        if (Math.abs(x - 0.0) < EPS) return new double[]{-(L - z), y};          // Left
        if (Math.abs(x - L)   < EPS) return new double[]{2.0 * L - z, y};       // Right
        if (Math.abs(y - 0.0) < EPS) return new double[]{x, z - L};             // Front
        if (Math.abs(y - L)   < EPS) return new double[]{x, 2.0 * L - z};       // Back
        return null;
    }

    // ---- shortest surface distance (excluding bottom) between different faces ----
    static double shortestSurfaceDistance(Pt a, Pt b) {
        double best = Double.POSITIVE_INFINITY;
        char[] roots = {'T','F','B','L','R'};
        for (char root : roots) {
            Pt ar = rotateToRootTop(a, root);
            Pt br = rotateToRootTop(b, root);

            // skip if either lands on bottom (z' == 0)
            if (Math.abs(ar.z) < EPS || Math.abs(br.z) < EPS) {
                continue;
            }
            double[] pa = mapToTopNet2D(ar);
            double[] pb = mapToTopNet2D(br);
            if (pa == null || pb == null) continue;

            double d = hypot(pa[0] - pb[0], pa[1] - pb[1]);
            if (d < best) best = d;
        }
        if (!Double.isFinite(best)) {
            // Shouldn't happen under constraints; fallback if same face:
            char fa = faceOf(a), fb = faceOf(b);
            if (fa == fb) return chordSameFace(a, b, fa);
            throw new RuntimeException("No valid unfolding found (check inputs/constraints).");
        }
        return best;
    }

    static double legDistance(Pt a, Pt b) {
        char fa = faceOf(a), fb = faceOf(b);
        if (fa == fb) {
            double chord = chordSameFace(a, b, fa);
            return chord * (Math.PI / 3.0);  // 60° arc
        }
        return shortestSurfaceDistance(a, b);
    }

    // ---- utils ----
    static double hypot(double dx, double dy) {
        return Math.hypot(dx, dy);
    }

    // ---- MixOfAll.main I/O ----
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Read all input into tokens (robust to newlines/spaces)
        List<String> toks = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; ) {
            line = line.trim();
            if (!line.isEmpty()) {
                String[] parts = line.split("\\s+");
                Collections.addAll(toks, parts);
            }
        }
        if (toks.isEmpty()) return;

        int N = Integer.parseInt(toks.get(0));

        // Join the rest without spaces; split by commas
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < toks.size(); i++) sb.append(toks.get(i));
        String rest = sb.toString().replace(" ", "");
        String[] numStrs = rest.split(",");
        if (numStrs.length != 3 * N)
            throw new IllegalArgumentException("Expected " + (3*N) + " numeric values, got " + numStrs.length);

        List<Pt> pts = new ArrayList<>();
        for (int i = 0; i < 3 * N; i += 3) {
            double x = Double.parseDouble(numStrs[i]);
            double y = Double.parseDouble(numStrs[i + 1]);
            double z = Double.parseDouble(numStrs[i + 2]);
            pts.add(new Pt(x, y, z));
        }

        double total = 0.0;
        for (int i = 0; i < N - 1; i++) {
            double d = legDistance(pts.get(i), pts.get(i + 1));
            total += round2HalfUp(d);
        }

        // Print exactly two decimals
        System.out.printf(Locale.US, "%.2f%n", total);
    }
}