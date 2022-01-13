const express = require('express')
const router  = express.Router()
const bcrypt =require('bcrypt')
const User = require('../models/User')
router.post('/signup', (req, res, next)=>{
    const emailId = req.body.emailId
    User.findOne({emailId: emailId}).exec().then(
        user=>{
            if(user){
                res.status(409).json({
                    Message: 'An Account With Same Email Id Exists'
                })
            }
            else{
                const password = req.body.password
                bcrypt.hash(password, 10, (err, hash)=>{
                    if(err){
                        return res.status(500).json(err)
                    }
                    const newUser = new User({
                        emailId: emailId,
                        password: hash
                    })
                    newUser.save().then(
                        doc=>{
                            res.status(200).json(doc)
                        }
                    ).catch(
                        err=>{
                            res.status(500).json(err)
                        }
                    )
                })
            }
        }
    )
    .catch(
        err=>{res.status(500).json(err)}
    )
})

module.exports = router
