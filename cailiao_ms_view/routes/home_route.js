var express = require('express');
var router = express.Router();

router.get('/home.html', function(req, res, next) {
  res.render('home/home');
});

module.exports = router;