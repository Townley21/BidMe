//
//  ListingTableViewCell.swift
//  BidMe
//
//  Created by Brandon Townley on 10/3/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import UIKit

class ListingTableViewCell: UITableViewCell {

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
