i = int(input())
for i in range (1,i):
    if i / 3 and i /5:
        print("FizzBuzz")
    if i / 3 and not i / 5:
        print("Fizz")
    if i / 5 and not i / 3:
        print("Buzz")
    if not i / 3 or not i / 5:
        print(i)
