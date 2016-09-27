import sys
import traceback


def save_if_allowed(fn):
    def wrapped(*args, **kwargs):
        try:
            return fn(*args, **kwargs)
        except Exception as exc:
            print "The exception:"
            print "".join(traceback.format_exception(*sys.exc_info()))
            raise exc
            return None
    return wrapped


@save_if_allowed
def stuff():
    raise Exception("stuff")


def foo():
    stuff()

foo()
