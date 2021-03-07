# shopping-cart



Engineering Technical Test 2 (Cart)

**Amaysim Shopping Cart Exercise**

Amaysim is rebuilding our shopping cart. In this new version we want to allow our customers to purchase multiple SIM cards simultaneously. You

have been engaged to build this new version.

We will start with the following products in our catalogue:

**Product Code Product Name Price**

ult\_small

ult\_medium

ult\_large

1gb

Unlimited 1GB

Unlimited 2GB

Unlimited 5GB

$24.90

$29.90

$44.90

1 GB Data-pack $9.90

As launching the new cart is kinda a big deal, we'd like to have a few special offers and promotions to attract new customers:

A 3 for 2 deal on Unlimited 1GB Sims. So for example, if you buy 3 Unlimited 1GB Sims, you will pay the price of 2 only for the first

month.

The Unlimited 5GB Sim will have a bulk discount applied; whereby the price will drop to $39.90 each for the first month, if the customer

buys more than 3.

We will bundle in a free 1 GB Data-pack free-of-charge with every Unlimited 2GB sold.

Adding the promo code 'I<3AMAYSIM' will apply a 10% discount across the board.

As the market tends to fluctuate in terms of pricing, the rules around this need to be as flexible as possible as they can change with little notice.

Customers can add items to the cart in any order.

**Interface**

The interface to our cart looks like this:

cart = ShoppingCart.new(pricingRules)

cart.add(item1)

cart.add(item2, promo\_code)

cart.total

cart.items

**The Programming Exercise**

Your task is to implement a shopping cart that satisfies the requirements described above and execute the following scenarios (and verify the

expected outcomes):

**Scenario**

**Items Added**

**Expected Cart Total**

**Expected Cart Items**

3 x Unlimited 1 GB

1 x Unlimited 5 GB

2 x Unlimited 1 GB

4 x Unlimited 5 GB

1 x Unlimited 1 GB

2 X Unlimited 2 GB

2 X 1 GB Data-pack

1

3 x Unlimited 1 GB

1 x Unlimited 5 GB

2 x Unlimited 1 GB

4 x Unlimited 5 GB

1 x Unlimited 1 GB

2 X Unlimited 2 GB

$94.70

2

3

$209.40

$84.70





4

1 x Unlimited 1 GB

$31.32

1 x Unlimited 1 GB

1 x 1 GB Data-pack

1 x 1 GB Data-pack

'I<3AMAYSIM' Promo Applied

**Technical Guidance**

use the programming language and tooling of your choice (preferably Ruby/Java/JS)

make your source code available on Github/Bitbucket (or the online repo of your choosing)

try not to spend more than 2 hours maximum. (We don't want you to lose a weekend over this!)

don't build guis etc; we're more interested in your approach to solving the given task, not how shiny it looks

don't use any frameworks (rails, spring etc), or any external jars/gems (unless they're for testing)


