var express = require('express');
var router = express.Router();
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

router.post('/sendAlertMessage',function(req,res){
    var uemail = req.body.email;
    var message = req.body.message;
    var sql = "insert into helpmessages(uemail,message) values('"+uemail+"','"+message+"')";
    con.query(sql,function(err,result){
        if(err){
            res.json({
                success : false,
                message : err
            });
        }else{
            res.json({
                success : true,
                message : "Alert message submitted!"
            });
        }
    });
});

router.get('/getHelpMessages',function(req,res){
    var sql="select * from helpmessages";
    con.query(sql,function(err,result){
        if(err){
            res.json({
                success : false,
                message : "Error!"
            });
        }else{
            res.json({
                success : true,
                data : result
            })
        }
    });
    
});


module.exports = router;
