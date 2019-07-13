var express = require('express');
var router = expresss.Router();
var jwt    =   require('jsonwebtoken');
var mysql = require('mysql');
var secret = "DR.reddys";

var con = mysql.createConnection({
    host: "localhost",
    user: "root",
    database: 'CFG',
    password: ""
});

router.post('/login',function(req,res){
    var email = req.body.email;
    var password = req.body.password;
    var sql = "select * from trainers where temail='"+email+"'";
    if(email==null){
        res.json({
            success : false,
            message : "Please enter the email"
        });
    }
    con.query(sql,function(err,result){
        if(err){
            res.json({
                success : false,
                error : err
            });
        }
        else{
            var t;
            
            result.forEach(trainer => {
               t = trainer;
               
            });
            if(t==null){
                res.json({
                    success : false,
                    message : "No Trainer found!"
                });
            }else{
                if(t){
                    if(t.password == password){


                        var token=jwt.sign({name: t.name , email: t.email , mobile: t.mobile , password: t.password , DOB : t.DOB , gender : t.gender},secret,{expiresIn:'240000h'});
                        res.json({
                            success : true,
                            message : "Trainer logged in succesfully!",
                            token : token
                        })
                    }else{
                        res.json({
                            success : true,
                            message : "OOPS, Enter the correct password!"
                        });
                    }
                }
            }
        }
    });
});


router.get('/getHelpMessages',function(req,res){
    var sql="select * from helpmessages";
    var name, mobile, email, message,al;
    var alerts=[]
    con.query(sql,function(err,result){
        result.forEach(alert => function(){
            var uid=alert.uid;
            message = alert.message;
            sql="select uname,uemail,mobile from users where uid='"+uid+"'";
            con.query(sql,function(err,result){
                name = result.uname;
                mobile = result.mobile;
                email = result.email;
            });
            al={
                name : name,
                mobile : mobile,
                email : email,
                message : message
            }
            alerts.push(al);
        });
        res.json({
            success : true,
            data : alerts
        });
    });
});


module.exports = router;
