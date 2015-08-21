//
//  ViewController.swift
//  EarningsTracker
//
//  Created by Sanjoy Ghosh on 8/18/15.
//  Copyright © 2015 Sanjoy Ghosh. All rights reserved.
//

import Cocoa

class ViewController: NSViewController {
    
    // MARK: Properties
    @IBOutlet weak var datePicker: NSDatePicker!
    @IBOutlet weak var goButton: NSButton!
    @IBOutlet weak var labelTextField: NSTextField!

    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Do any additional setup after loading the view.
        datePicker.dateValue = NSDate()
    }

    override var representedObject: AnyObject? {
        didSet {
        // Update the view, if already loaded.
        }
    }

    // MARK: Actions
    @IBAction func showEarningsForDate(sender: NSButton) {
        labelTextField.stringValue = "what is the date?"
    }
}

