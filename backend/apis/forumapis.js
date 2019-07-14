var express = require('express');
var router = express.Router();
var mysql = require('mysql');
var con = mysql.createConnection({
    host: "localhost",
    user: "root",
    database: 'CFG',
    password: ""
});

router.post('/addQuestion',function(req,res){
    var question = req.body.question;
    var email = req.body.createdby;
    var role = req.body.role;
    var sql = "insert into questions(createdby,question,role) values('"+email+"','"+question+"','"+role+"')";
    con.query(sql,function(err,result){
        if(err){
            res.json({
                success : false,
                message : "Error Occuring!"
        });
        }else{
            res.json({
                success : true,
                message : "Question submitted!"
            });
        }
    });
});

router.post('/addAnswer',function(req,res){
    var role = req.body.role;
    var answeredby = req.body.answeredby;
    var qid = req.body.qid;
    var answer  = req.body.answer;
    var sql = "insert into answers(qid,answeredBy,role,answer) values('"+qid+"','"+answeredby+"','"+role+"','"+answer+"')";
    con.query(sql,function(err,result){
        if(err){
            res.json({
                success : false,
                message : "Error!"
            });
        }else{
            res.json({
                success : true,
                message : "Answer Subitted Succesfully!"
            });
        }

    });

});


router.post('/getforums',function(req,res){
    var sql = "select questions.question,questions.createdby,questions.role,answers.answer,answers.answeredby,answers.role from questions INNER JOIN answers on questions.qid=answers.qid";
    con.query(sql,function(err,result){
        if(err){
            res.json({
                success : false,
                error :err
            });
        }else{
            if(result){
                res.send(result);
            }
        }
    });
});


module.exports = router;
