class Solution:
    def calPoints(self, operations: List[str]) -> int:
        prev = []
        sum = 0
        
        for o in operations:
            match o:
                case '+':
                    prev.append(prev[-1] + prev[-2])
                case 'D':
                    prev.append(prev[-1]*2)
                case 'C':
                    sum -= prev.pop()
                case _:
                    prev.append(int(o))

            sum += prev[-1] if o != 'C' else 0

        return sum