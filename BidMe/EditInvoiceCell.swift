//
//  EditInvoiceCell.swift
//  BidMe
//
//  Created by Jerin Sharif on 11/3/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import UIKit

protocol MyCellDelegate: AnyObject {
    func btnCloseTapped(cell: EditInvoiceCell)
}
class EditInvoiceCell: UITableViewCell {
    @IBOutlet var btnClose: UIButton!

    //2. create delegate variable
    weak var delegate: MyCellDelegate?

    //3. assign this action to close button
    @IBAction func btnCloseTapped(sender: AnyObject) {
        //4. call delegate method
        //check delegate is not nil with `?`
        delegate?.btnCloseTapped(cell: self)
    }
    
    @IBOutlet weak var contractorLabel: UILabel!
    @IBOutlet weak var priceLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
}
