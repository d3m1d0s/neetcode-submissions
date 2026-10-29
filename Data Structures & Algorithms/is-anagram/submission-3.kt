class Solution {
    fun isAnagram(s: String, t: String): Boolean {

        if (s.length != t.length) {
            return false
        }

        val lettersS = HashMap<Char, Int>()
        val lettersT = HashMap<Char, Int>()

        for (char in s) {
            if (!lettersS.containsKey(char)) lettersS.put(char, 1)
            else lettersS.put(char, (lettersS?.get(char) ?: 1)+1)
        }

        for (char in t) {
            if (!lettersT.containsKey(char)) lettersT.put(char, 1)
            else lettersT.put(char, (lettersT?.get(char) ?: 1)+1)
        }

        for (key in lettersS.keys) {
            if (!lettersT.containsKey(key)) {
                return false
            } else {
                if (lettersS.get(key) != lettersT.get(key)) return false
            }
        }

        return true
    }
}
