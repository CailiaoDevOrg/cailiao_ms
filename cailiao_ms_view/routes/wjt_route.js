var express = require('express');
var router = express.Router();

router.get('/wjt/list.html', function(req, res, next) {
    res.render('wjt/list');
});

router.get('/wjt/create.html', function(req, res, next) {
    res.render('wjt/create'); 
});

router.post('/wjt/new/save.html', function(req, res, next) {
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    res.end('Hello World\n' + req.body.name);
});

module.exports = router;