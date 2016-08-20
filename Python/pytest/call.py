fibonacci_rpc = FibonacciRpcClient()
result = fibonacci_rpc.call(4)
print "fib(4) is %r" % (result,)