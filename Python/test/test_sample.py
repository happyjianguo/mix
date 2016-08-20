from unnecessary_math import multiply
import pytest

@pytest.fixture(scope="function")
def hello(request):
    print "hello"
    request.addfinalizer(world)

def world():
    print "world"


def test_numbers_3_4(hello):
    print "test_numbers_3_4\n"
    assert multiply(3, 4) == 12

def test_numbers_4_5():
    assert multiply(3, 4) == 12