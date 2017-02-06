To build the code use 

mvn package

An example is in the com.ravi.TypeReduction.Example.Tipping class which is using the following data

Membership Functions:

For Food : \
Rancid Upper - [0, 0, 1, 5], Rancid Lower - [0, 0, 0.5, 4.5]\
Delicious Upper - [4, 8, 9, 9], Delicious Lower - [4.5, 8.5, 9, 9]

For Service : \
Poor Upper - [0, 0, 1, 3], Poor Lower - [0, 0, 0.5, 2.5]\
Good Upper - [1, 3, 5, 7], Good Lower - [1.5, 3.5, 4.5, 6.5]\
Excellent Upper - [5, 7, 9, 9], Excellent Lower- [5.5, 7.5, 9, 9]

For Tip : \
Cheap Upper - [0, 6, 6, 12], Cheap Lower - [2, 6, 6, 10]\
Average Upper - [10, 15, 15, 20], Average Lower - [12, 15, 15, 18]\
Generous Upper - [18, 24, 24, 30], Generous Lower- [20, 24, 24, 28]

Rulebase:

*If the food is rancid and the service is poor, then the tip is cheap\
*If the food is rancid and the service is good, then the tip is cheap\
*If the food is rancid and the service is excellent, then the tip is average\
*If the food is delicious and the service is poor, then the tip is average\
*If the food is delicious and the service is good, then the tip is average\
*If the food is delicious and the service is excellent, then the tip is generous\

