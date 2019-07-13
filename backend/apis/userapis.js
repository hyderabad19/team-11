var express = require("express");
var router = express.Router();
var mysql = require('mysql');
var jwt 	    =   require('jsonwebtoken');
var secret = "DR.reddys"

var con = mysql.createConnection({
    host: "localhost",
    user: "root",
    database: 'CFG',
    password: ""
});

con.connect(function(err) {
    if (err) throw err;
    
});

router.post('/login',function(req,res){
    var email = req.body.email;
    var password = req.body.password;
    var sql = "select * from users where uemail='"+email+"'";
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
            var u;
            
            result.forEach(user => {
               u = user;
               
            });
            if(u==null){
                res.json({
                    success : false,
                    message : "No user found!"
                });
            }else{
                if(u){
                    if(u.password == password){


                        var token=jwt.sign({name: u.name , email: u.email , mobile: u.mobile , password: u.password , DOB : u.DOB , gender : u.gender},secret,{expiresIn:'240000h'});
                        res.json({
                            success : true,
                            message : "User logged in succesfully!",
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

router.post('/getUserDetails',function(req,res){
    var token = req.body.token;
    if(token){
        jwt.verify(token,secret,function(err,decoded){
            if(err){
                res.json({success: false , message: 'Invalid token'});
            }
            else{
                var userDetails = decoded;
                res.json({
                    success : true,
                    data : userDetails
                });
                
            }
        });
    }else{
        res.json({success:false,message:'Please provide a token'});
    }
});



router.post('/register',function(req,res){
    var name = req.body.name;
    var email = req.body.email;
    var mobile = req.body.mobile;
    var password = req.body.password;
    var DOB = req.body.DOB;
    var gender = req.body.gender;

    var sql = "INSERT INTO users (uname, uemail,mobile, password, DOB, gender) VALUES ('"+name+"','"+email+"','"+mobile+"','"+password+"','"+DOB+"','"+gender+"')";

    con.query(sql, function (err, result) {
        if (err){
            res.json({
                success : false,
                message : "Error Please try again filling the form correctly!"
            })
        }
        res.json({
            success : true,
            message : "User successfully created"
        })
    });
});

router.post('/getVideos',function(req,res){
    var sql = "select * from content";
    con.query(sql, function(err, result){
        if(err){
            res.json({
                success : false,
                message : "An error occured"
            });
        }
        else{
            var videos=[];
            var videoTitles=[];
            result.forEach(content => {
                console.log(content);
                if(content.contentType=="video"){
                    videos.push(content.contentLocation);
                    videoTitles.push(content.contentTitle);
                }
                
            });
            var data = {
                contentType : "video",
                contentTitle : videoTitles,
                contentLocation : videos
            }
            res.json({
                success  : true,
                data : data
            });
        }
    })
});


router.post('/quizz',function(req,res){
    var qno = req.body.qno;
    var sql = "select * from quizz where qno='"+qno+"'";
    con.query(sql,function(err,result){
        if(err){
            res.json({
                success : false,
                error : err
            });
        }else{
            var que;
            var answer;
            var option=[];
            result.forEach(question => {
                que = question.question;
                if(question.isCorrect==1){
                    answer = question.options;
                }
                option.push(question.options);
                
            });
            var question={
                questionName : que,
                options : option,
                correctAnswer : answer
            }
            res.json({
                success : true,
                question : question,
            });
        }
    });

});

module.exports = router;
