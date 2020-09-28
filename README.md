# AndroidDB
### This project comprises of an android app which loads data from firebase database and displays it in `RecyclerView`.
#### The data is stored in following hierarchy
                        --users
                          |--data
                             |--id
                                |--name
                                |--age
                                |--timestamp
* The data is loaded in `RecyclerView` in descending order of `timestamp` ( Collections.reverse(list); is used)
* The database only maintains ten latest data. So a firebase function is deployed which deletes the old data and maintains the latest ten data.
The function is [functions/index.js](https://github.com/abhi211199/db/blob/master/function/functions/index.js)

