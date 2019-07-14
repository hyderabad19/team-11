var express = require('express');
var router = express.Router();
var mysql = require('mysql');

var con = mysql.createConnection({
    host: "localhost",
    user: "root",
    database: 'CFG',
    password: ""
});

router.post('/addTrainer',function(req,res){
    email = req.body.email;
    password = req.body.password;
    var sql = "insert into trainer(email,password) values('"+email+"','"+password+"')";
    con.query(sql,function(err,result){
        if(err){
            res.json({
                success : false,
                message : "Error!"
            });
        }else{
            res.json({
                success : true,
                message : "Trainer succesfully created!"
            });
        }
    });
});

module.exports = router;