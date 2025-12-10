import pytest
@pytest.fixture
def number_list():
    return list(range(0, 11)) 

def test_sum_of_list(number_list):
    assert sum(number_list) == 55
