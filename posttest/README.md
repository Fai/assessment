# Lottery Ticket Feature
## Business Requirement
- Admin can create a lottery ticket with 6 digits
- User can view all lottery tickets
- User can buy a lottery ticket
- User can view all lottery tickets that they have bought and the total amount of money they have spent
- User can sell back the lottery ticket that they have bought
- No need to worry about the money that the user has to pay, other systems have already checked it
- UserID of the user is a 10-digit number
- Admin feature must have permission check
- No lottery draw related
- Need to implement PostgreSQL
- Need to create Table called lottery to manage lottery and user_ticket to store user's buy/sell list
- Need to open the service through port 8888
- Need to call Database URL through Environment variable named DATABASE_URL
## Dev Environment
- [x] git config
## POSTGRES database set up
- [x] lotteries table
- [x] user_ticket table
- [x] users table
- [x] database connection
## Restful API CRUD
- [x] GET /lotteries
- [ ] POST /users/:userId/lotteries/:ticketId
- [ ] GET /users/:userId/lotteries
- [ ] DELETE /users/:userId/lotteries/:ticketId
- [ ] response status code
## Admin
- [x] POST /admin/lotteries
- [x] validate data
- [x] protect admin route
## docker Container
- [x] docker container
- [x] docker-compose
- [x] containerize
## code quality
- [ ] unit test - case coverage
- [ ] proper type declaration
- [ ] test cases
- [x] proper transaction
- [ ] code maintenance
- [ ] readability
- [ ] app layer
- [x] no nested if
- [x] no duplicate code
- [ ] method parameter
- [ ] data governance
- [ ] clean up code