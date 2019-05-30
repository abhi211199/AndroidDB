# db
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
#### Screenshots and Videos
* [Entry of 1st  data](https://drive.google.com/open?id=1jrTQEMRJCCyhAQ6NnyJJzmANB0aWf9h4)
* [Intermediate stage](https://drive.google.com/open?id=1LRg3nnrtaR3owX-z2dUiJbIkqCmDooOM)
* [Entry of 10th data](https://drive.google.com/open?id=1aXmH0Ql1r2gEBedl8AGaZBFW8aDco2SH)
* [Deletion of oldest data](https://drive.google.com/open?id=1yQXVYhlQxybBzRCNfQSU4CchBpw3-zi_)
* [Logs](https://drive.google.com/open?id=1FjxWrNeuW_BDt1jfgv9t2y7S6lwvEw64)
* [Entering data](https://drive.google.com/open?id=1yljYeahT_ZiFH6HVdqDyjYDzI6jlZlbq)
* [Display of data in descending order](https://drive.google.com/open?id=131pm2YDeXKKd1ViGA8owZ2ajEHw337PN)
