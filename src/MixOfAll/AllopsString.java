package MixOfAll;

class AllopsString {
    public static void main(String[] args) {

        // create
        StringBuilder sb = new StringBuilder("abc");
        System.out.println("start: " + sb);

        // append
        sb.append("XYZ");
        System.out.println("append: " + sb);

        // insert at index
        sb.insert(2, "e");
        System.out.println("insert: " + sb);

        // replace range [start, end)
        sb.replace(1, 3, "ERT");
        System.out.println("replace: " + sb);

        // set a single char
        sb.setCharAt(0, 'Q');
        System.out.println("setCharAt: " + sb);

        // delete range [start, end)
        sb.delete(2, 4);
        System.out.println("delete range: " + sb);

        // delete a single char
        sb.deleteCharAt(0);
        System.out.println("deleteCharAt: " + sb);

        // length
        System.out.println("length: " + sb.length());

        // capacity (internal buffer)
        System.out.println("capacity: " + sb.capacity());

        // ensure capacity
        sb.ensureCapacity(50);
        System.out.println("capacity after ensure: " + sb.capacity());

        // reverse
        sb.reverse();
        System.out.println("reverse: " + sb);

        // substring (returns String, not modifies)
        String sub = sb.substring(1, 3);
        System.out.println("substring(1,3): " + sub);

        // back to string
        String s = sb.toString();
        System.out.println("final string: " + s);
    }
}

