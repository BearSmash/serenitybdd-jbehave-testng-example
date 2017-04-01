Meta:

Narrative:
As a customer ready to finalize my order
I want to see my total cost with shipping right after selecting shipping options
So that I can quickly decide if I'm okay with my shipping choice

Scenario: Customer selects standard shipping option and sees new total
Given an item of cost 15.00 is in the cart
When the customer chooses standard shipping
Then the customer sees a total cost of 19.00