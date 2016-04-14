var express = require('express');
var http = require('http');
var router = express.Router();

router.get('/wjt/list.html', function(req, res, next) {
    res.render('wjt/list');
});

router.get('/wjt/create.html', function(req, res, next) {
    res.render('wjt/create'); 
});

router.post('/wjt/new/save.html', function(req, res, next) {
    console.log(req.body);
    var data = {
        name: req.body.name,
        description: req.body.desc,
        beginTime: req.body.beginTime,
        endTime: req.body.endTime,
        templateUrl: req.body.pageUrl,
        status: 1
    }
    data = JSON.stringify(data);
    var opt = {  
        method: "POST",  
        host: "localhost",  
        port: 7878,  
        path: "/qtms/saveQuestionnaireTemplateTemp.html",  
        headers: {  
            "Content-Type": 'application/json'
        }  
    };
    var req = http.request(opt, function(serverFeedback) {
        if (serverFeedback.statusCode == 200) {
            var body = "";
            serverFeedback.on('data', function(data) { 
                body += data; 
            }).on('end', function() { 
                var retCode = JSON.parse(body).retCode;
                if (retCode == 200) {
                    res.send(200, body);
                } else {
                    res.send(500, "error");
                }
            });
        } else {
            res.send(500, "error");
        }
    });  
    req.write(data + "\n");  
    req.end();
});

module.exports = router;