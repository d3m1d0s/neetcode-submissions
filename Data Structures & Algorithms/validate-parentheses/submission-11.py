class Solution:
    def isValid(self, s: str) -> bool:
        prths = {
            '{' : '}',
            '(' : ')',
            '[' : ']'
        }
        close = []
        for c in s:
            match c:
                case n if n in prths.keys():
                    close.append(prths.get(c))
                case n if not close or n != close.pop() or n not in prths.values():
                    return False
            
        return True if not close else False