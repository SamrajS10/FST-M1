import pytest

@pytest.fixture
def wallet():
    amount = 0
    return amount

@pytest.mark.parametrize(
    "earned, spent, expected",
    [
        (30, 10, 20),
        (100, 20, 80),
        (50, 50, 0),
        (10, 5, 5)
    ]
)
def test_wallet_transactions(wallet, earned, spent, expected):

    wallet = wallet
    wallet += earned
    wallet -= spent
    assert wallet == expected
