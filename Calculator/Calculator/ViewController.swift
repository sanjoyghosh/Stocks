//
//  ViewController.swift
//  Calculator
//
//  Created by Sanjoy Ghosh on 6/7/15.
//  Copyright (c) 2015 Sanjoy Ghosh. All rights reserved.
//

import Cocoa

class ViewController: NSViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override var representedObject: AnyObject? {
        didSet {
        // Update the view, if already loaded.
        }
    }

    var userIsInTheMiddleOfTypingANumber: Bool = false

    @IBOutlet weak var display: NSTextFieldCell!
    @IBAction func appendDigit(sender: NSButton) {
        let digit = sender.title
        if userIsInTheMiddleOfTypingANumber {
            display.title = display.title + digit
        }
        else {
            display.title = digit
            userIsInTheMiddleOfTypingANumber = true
        }
        print("digit = \(digit)")
    }
}

