# Centers for Medicare & Medicaid Services
Input(itcont.txt) 
- a list of all drugs, the total number of UNIQUE individuals who prescribed the medication, and the total drug cost

Output(top_cost_drug.txt) 
- a list of all drugs (drug_name,number of prescribers, total_cost) must be listed in descending order based on the total drug cost and if there is a tie, drug name.

#Algorithm:

I used two hashmaps and Comparator. 
Comparator is very efficient for streaming data and static data. 
- a hashmap to store drugs and respective costs to calculate total cost
- a hashmap to store drugs and prescibers to calculate the total prescibers 
- I used Comparator for sorting purpose

#Tests:

test_1
- tests the calculation of total cost
- tests the order of the output list based on total cost
- tests the number of prescribers

test_2
- tests descending order based on the total drug cost and with a tie
- tests drug_name order is considered when there is a tie in totals cost 

