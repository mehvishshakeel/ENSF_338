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

i=0
feb = []
while True:
    n = int(input("input the last number of the Fibonacci sequence:" ))
    seq = func(n)
    

    
    
    while i < len(feb_seq):
        feb.append(feb_seq[i])
        i += 1
    print (seq)
    print (feb)        
              
