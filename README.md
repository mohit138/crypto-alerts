# crypto-alerts
The project allows to create alerts for crypto currencies. 
The alerts are stored, are compared with the crypto exchange rates and triggered as soon as rates cross the execution mark. MongoDB is used to store active alerts and triggered alerts.

Following are the APIs :- <br>
* To view active alerts - /active-alerts <br>
* To view active alerts for a specific currency - /active-alerts/BTC <br>
* To add an alert - /add-alert <br>
( with AlertRequest in body. AlertRequest - {userId, script, price, moreThan} ) <br>
* To delete an alert - /delete-alert <br>
( with AlertRequest in body ) <br>
To get executed alerts - /alerts-history <br>