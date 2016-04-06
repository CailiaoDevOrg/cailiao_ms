var express = require('express');
var router = express.Router();

router.get('/wjt/list.html', function(req, res, next) {
    res.render('wjt/list');
});

router.get('/wjt/create.html', function(req, res, next) {
    res.render('wjt/create'); 
});

module.exports = router;