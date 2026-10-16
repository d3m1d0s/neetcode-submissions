class MinStack:

    def __init__(self):
        self.stack = []
        self.mn = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        self.mn.append(val) if not self.mn else self.mn.append(val) if val <= self.mn[-1] else 0

    def pop(self) -> None:
        self.mn.pop() if self.mn[-1] == self.stack.pop() else 0

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.mn[-1]
        
