'use strict';
const functions = require('firebase-functions');
const admin = require('firebase-admin');
admin.initializeApp();
 exports.deleteOldItems = functions.database.ref('/users/data').onWrite(async (change) => {
   const messagesRef = admin.database().ref('/users/data');
   var i=0,j=0;
    messagesRef.once('value', (snapshot) => {
        snapshot.forEach((child) => {
          i++;
        });
        if(i>10)
        {
          snapshot.forEach((child) => {
            j++;
            if(j==1){
            messagesRef.child(child.key).remove();
            console.log("oldest child deleted");
        }
            // break;
          });
        }
        else
        {console.log("less than 10 child");}
      });
});
