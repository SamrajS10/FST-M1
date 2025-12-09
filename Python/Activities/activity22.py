import pytest

def test_sum():
    a = 7
    b = 13
    result = a + b
    assert result == 20

def test_difference():
    x = 40
    y = 18
    result = x - y
    assert result == 22

@pytest.mark.activity
def test_product():
    m = 6
    n = 9
    result = m * n
    assert result == 54

@pytest.mark.activity
def test_quotient():
    p = 81
    q = 9
    result = p / q
    assert result == 9
