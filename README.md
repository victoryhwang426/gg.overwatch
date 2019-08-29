# Java Code Challenge
Implement a Java REST service that consumes the unofficial Overwatch API and provides the data via it’s own REST API. You may use any existing REST framework, e.g. Dropwizard, Spring, etc. You should not spend more than 2 hours on this challenge, if you do not finish in time, don’t worry and just provide us a reason why you decided to omit certain features. Once you are done, send us a link to the git repository within 7 days.

# Get hero information into the database from the unofficial Overwatch API
    1. https://overwatch-api.net/api/v1/hero/
    2. https://overwatch-api.net/api/v1/hero/{hero_id}
    3. Fields required: id, name, real_name, health, armour, shield
    
    Also get information about the Heroes abilities and provide them using a relation:

    4. https://overwatch-api.net/api/v1/ability/
    5. https://overwatch-api.net/api/v1/ability/{ability_id}    
    6. Fields required: id, name, description, is_ultimate
    
# Create an API that provides information about Overwatch heroes and their abilities Your API should have the following endpoints:
    1. /api/heros - hero list
    2. /api/heros/{hero_id} - hero data
    3. /api/heros/{hero_id}/abilities - hero ability list
    4. /api/abilities/ - ability list
    5. /api/abilities/{ability_id} - ability data

# Hints:
A user-agent might be required to use the API programmatically

# Bonus points:
    1. API documentation, e.g. Swagger
    2. Data persistence, e.g. file system, H2 or other database
    3. Tests