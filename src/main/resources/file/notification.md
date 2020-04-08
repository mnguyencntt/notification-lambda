# Notification - Use Cases



| API | Method | Description |
| ------ | ------ | ------ |
| /send | POST | ... |




## Send notification to Buyer
Given a notification sends to a Buyer by SMS/Email,\
When the user submits Order & Payment & Delievery infos,\
Then the platform sends the detail Order & Payment & Delievery infos to Buyer by SMS/Email.

```
POST /send

Parameters
* buyerId (required): userId of Buyer which will be sent notification.
* sellerId (required): userId of Seller which will be sent notification.
* orderId (required): id of Order to get the info for Subject message.
* deliveryId (required): id of Delivery to get the info for ContentBody message.
* notificationType (required): type of notification (SMS/Email).
* eventType (required): OrderCreated or DeliveryCreated or DeliveryCompleted.
```
#### Sample Request
```
{
    "buyerId": "UIB12345",
    "sellerId": "UIS12345",
    "orderId": "OI12345",
    "deliveryId": "DI12345",
    "notificationType": "Email",
    "eventType": "OrderCreated"
}
```
#### Sample Success Response
```
{
    "status": 200,
    "message": "Send notification Success",
    "data": [
        {
            "buyerId": "UIB12345",
            "sellerId": "UIS12345",
			"notificationType": "Email",
			"amount": "2"
        }
    ]
}
```
#### Sample Fail Response
```
{
    "status": 400,
    "message": "Send notification Fail. Invalid Email",
    "data":  [
        {
            "buyerId": "UIB12345",
            "sellerId": "UIS12345",
			"notificationType": "Email",
			"amount": "0"
        }
    ]
}


