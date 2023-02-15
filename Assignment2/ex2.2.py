import sys
sys.setrecursionlimit(20000)
import json
import timeit
import matplotlib.pyplot as plt

f = open('q2.json')
dict = json.load(f)

def func1(arr, low, high):
    if low < high:
        pi = func2(arr, low, high)
        func1(arr, low, pi-1)
        func1(arr, pi + 1, high)

def func2(array, start, end):
    p = array[start]
    low = start + 1
    high = end
    while True:
        while low <= high and array[high] >= p:
            high = high - 1
        while low <= high and array[low] <= p:
         low = low + 1
        if low <= high:
            array[low], array[high] = array[high], array[low]
        else:
            break
    array[start], array[high] = array[high], array[start]
    return high

    
def f_array (i):
    low = 0
    arr = dict[i]
    high = len(arr) - 1
    func1(arr, low, high) 
        


unoptimized_arr = []
x_axis=[]

for i in range(len(dict)):
    elapsed_time_uo = timeit.timeit(lambda:f_array(i),number=1)

    print(f"Execution time for un optimised is {elapsed_time_uo} seconds")
    unoptimized_arr.append(elapsed_time_uo)
    
    #elapsed_time = timeit.timeit(lambda:func(i),number=1)
    #print(f"Execution time for optimized is {elapsed_time} seconds")
    #Etime_opt.append(elapsed_time) 
    
    x_axis.append(len(dict[i]))


plt.plot(x_axis,unoptimized_arr, label = "Unoptimised QuickSort code" )

#plt.plot(Xval, Etime_opt, label = "Optimized code")
plt.legend()

plt.xlabel('Input size')
plt.ylabel('Execution time')
plt.show()    
