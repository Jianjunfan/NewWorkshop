def generate_num(num):
    print("in generate_num")
    if num==0:
        yield num
    yield num+1

def recursive_fibonacci(num):
    if num==1 or num==2:
        return num
    else:
        return recursive_fibonacci(num-1) + recursive_fibonacci(num-2)

def generate_fibonacci(index):
    start_num=1
    while True:
        num = recursive_fibonacci(start_num)
        print("fibnacci value is {}".format(num))
        start_num=start_num+1
        if start_num >index:
            break


def recursive_fibonacci_yield(num):
    if num==1 or num==2:
        yield num
    else:
        yield recursive_fibonacci(num-1) + recursive_fibonacci(num-2)

def generate_fibonacci_yield(index):
    start_num=1
    while True:
        for index in recursive_fibonacci_yield(start_num):
            print("the index is {}".format(index))
        start_num=start_num+1
        if start_num >index:
            break

def A001511():
    print("in A001511")
    yield 1
    for x in A001511():
        yield x+1
        yield 1
