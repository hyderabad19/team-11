var express = require('express');
var morgan = require('morgan');
var app = express();
var bodyParser = require('body-parser');
var port 			=	process.env.PORT||8080;
var mysql = require('mysql');
var con = mysql.createConnection({
    host: "localhost",
    user: "root",
    database: 'CFG',
    password: ""
});
  
con.connect(function(err) {
    if (err) throw err;
    console.log("Connected!");
});

var userapiRouter = require('./apis/userapis'); 
var forumapiRouter = require('./apis/forumapis');

app.use(morgan('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended : true}));
app.use('/forum',forumapiRouter);

app.get('/',function(req,res){
    res.send("HEllo world!");
});
app.use('/user',userapiRouter);


app.listen(port,function(){
	console.log("server running on port "+port);
});

module.exports=con;