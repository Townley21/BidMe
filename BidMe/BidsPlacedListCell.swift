//
//  BidsPlacedListCell.swift
//  BidMe
//
//  Created by Axel Mora on 11/2/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import UIKit

class BidsPlacedListCell: UITableViewCell {
    
    @IBOutlet var nameLabel: UILabel!
    @IBOutlet var addressLabel: UILabel!
    @IBOutlet var descriptionLabel: UILabel!
    
    @IBOutlet var bidCountLabel: UILabel!
    @IBOutlet var previewImage: UIImage!
    @IBOutlet var bidStaticLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
}
