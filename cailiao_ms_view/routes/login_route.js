var express = require('express');
var router = express.Router();
var loginController = require('../web/login/login_controller');

router.get(['/login.html', '/'], function(req, res, next) {
    res.render('login/login');
});

router.post('/login_check.html', loginController.loginCheck);

module.exports = router;