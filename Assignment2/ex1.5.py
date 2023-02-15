import matplotlib.pyplot as plt
import numpy as np
import timeit

#Optimized code
feb_seq = {}
def func(n):
    if n in feb_seq:
        return feb_seq[n]
    else:
        if n == 0 or n == 1:
            feb_seq[n] = n
            return feb_seq[n]
        
        else:

            feb_seq[n] = func(n-1) + func(n-2)
            return feb_seq[n]
def func2(t):
    for t in range(35):
        func(t)


#Orignal code
def func_o(n):
    if n == 0 or n == 1:
        return n
    else:
        return func_o(n-1) + func_o(n-2)

def func2_o(t):
    for t in range(35):
        func_o(t)

Etime_orig = []
Etime_opt = []
Xval = []

i=0
for i in range (35):

    elapsed_time_o = timeit.timeit(lambda:func_o(i),number=1)
    #print(f"Execution time for orignal is {elapsed_time_o} seconds")
    Etime_orig.append(elapsed_time_o)
    
    elapsed_time = timeit.timeit(lambda:func(i),number=1)
    #print(f"Execution time for optimized is {elapsed_time} seconds")
    Etime_opt.append(elapsed_time) 
    
    Xval.append(i)


plt.plot(Xval,Etime_orig, label = "Orignal code" )
plt.plot(Xval, Etime_opt, label = "Optimized code")
plt.legend()

plt.xlabel('Input size')
plt.ylabel('Execution time')
plt.show()