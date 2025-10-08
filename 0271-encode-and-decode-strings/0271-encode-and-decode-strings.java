public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for(String s : strs){
            encoded.append(s.length());
            encoded.append("#");
            encoded.append(s);
        }
        return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int delimiterPos = i;

            while(s.charAt(delimiterPos) != '#') delimiterPos++;

            int length = Integer.parseInt(s.substring(i, delimiterPos));
            int startPos = delimiterPos + 1;
            int endPos = startPos + length;

            decoded.add(s.substring(startPos , endPos));

            i = endPos;
        }
        return decoded;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));