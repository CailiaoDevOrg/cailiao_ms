var express = require('express');
var router = express.Router();

router.get('/wjt/list', function(req, res, next) {
    res.render('wjt/list.html');
});

router.get('/wjt/create', function(req, res, next) {
    res.render('wjt/create.html'); 
});

router.post('/wjt/new/save', function(req, res, next) {
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    res.end('Hello World\n' + req.body.name);
});

module.exports = router;