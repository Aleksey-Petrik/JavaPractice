package week1.day4;

import week1.day2.StdString1;
import week1.day2.StringUtils;
import week1.day3.ListHelper;
import week1.day3.ListNode;

import java.util.Arrays;

public class StdString2 extends StdString1 {

    public static void main(String[] args) {

        StdString2 std = new StdString2(new char[]{' ','A', ' ', ' '});
        System.out.println(std.trim());

        StdString2 std2 = new StdString2(new char[]{'=','=','=', 'j', 'e', '=', 'u', '=', 'm', '=', 'J', '=', 'W', '=', 'V', 'C', 'Y', '=', 'I', 'F', 'z', 'G', '=', 'y', '9', '=', 'B', 'N', '=', '5', 'K', '5', 'G', '=', 'g', 'Z', 'K', '=', 'i', 'M', '=', 'j', '=', 'q', '=', 'R', 'C', '=', '='});
        System.out.println(std2.removeCharacter('='));
        System.out.println(Arrays.toString(std2.split('=')));
    }

    public StdString2(char[] base) {
        super(base);
    }

    public StdString2() {
        super();
    }

    public StdString2(StdString2 that) {
        super(that);
    }

    public StdString2 toAsciiLowerCase() {
        char[] newBase = toCharArray().clone();
        for (int i = 0; i < newBase.length; i++) {
            newBase[i] = StringUtils.toAsciiLowercase(newBase[i]);
        }
        return new StdString2(newBase);
    }

    public StdString2 toAsciiUpperCase() {
        char[] newBase = toCharArray().clone();
        for (int i = 0; i < newBase.length; i++) {
            newBase[i] = StringUtils.toAsciiUppercase(newBase[i]);
        }
        return new StdString2(newBase);
    }

    public StdString2 subString(int from, int to) {
        if (from > to) {
            throw new IllegalArgumentException();
        }
        if (!(from >= 0 && from < to && to <= length())) {
            throw new IndexOutOfBoundsException();
        }
        char[] newBase = new char[to - from];
        System.arraycopy(toCharArray().clone(), from, newBase, 0, to - from);

        return new StdString2(newBase);
    }

    public StdString2 concat(StdString2... that) {
        int length = length();
        char[] newBase = new char[0];

        for (StdString2 chars : that) {
            length += chars.length();
        }

        if (length > 0) {
            newBase = new char[length];
            System.arraycopy(toCharArray().clone(), 0, newBase, 0, length());
            int pos = length();
            for (StdString2 chars : that) {
                char[] bufChars = chars.toCharArray().clone();
                System.arraycopy(bufChars, 0, newBase, pos, bufChars.length);
                pos += bufChars.length;
            }
        }
        return new StdString2(newBase);
    }

    public StdString2[] split(char separator) {
        char[] bufBase = new char[length() + 1];
        ListNode<StdString2> stdStringNodes = null;

        System.arraycopy(toCharArray().clone(), 0, bufBase, 0, length());
        bufBase[length()] = separator;

        boolean isPure = true;
        int to = 0;
        for (int i = 0; i < bufBase.length; i++) {
            if (bufBase[i] == separator) {
                if (i - to > 0 || isPure) {
                    StdString2 stdElem = isPure ? new StdString2() : new StdString2(subString(to, i));
                    stdStringNodes = ListHelper.addToEnd(stdStringNodes, stdElem);
                }
                to = i + 1;
            } else {
                isPure = false;
            }
        }

        return nodesToArray(stdStringNodes);
    }

    private StdString2[] nodesToArray(ListNode<StdString2> nodes) {
        StdString2[] stdString2s = new StdString2[ListHelper.length(nodes)];
        nodes = ListHelper.firstNode(nodes);

        int counter = 0;
        while (nodes != null) {
            stdString2s[counter++] = nodes.getValue();
            nodes = nodes.getNext();
        }
        return stdString2s;
    }

    public StdString2 trim() {
        int to = -1;
        int from = -1;
        char[] bufBase = toCharArray();
        for (int i = 0; i < length(); i++) {
            if (to == -1 && bufBase[i] != ' ') {
                to = i;
            }
            if (bufBase[i] != ' ') {
                from = i;
            }
        }
        return to < 0 ? new StdString2() : new StdString2(subString(to, from + 1));
    }

    public StdString2 removeCharacter(char toRemove) {
        int newBaseLength = 0;
        char[] bufBase = toCharArray();
        for (int i = 0; i < length(); i++) {
            if (bufBase[i] != toRemove) {
                newBaseLength++;
            }
        }
        char[] newBase = new char[newBaseLength];
        int counter = 0;
        for (int i = 0; i < length(); i++) {
            if (bufBase[i] != toRemove) {
                newBase[counter++] = bufBase[i];
            }
        }
        return new StdString2(newBase);
    }
}
