# StudyCafe
// 로그인 버튼 이벤트
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String phoneNum = userPhoneNumber.getText();
				String password = new String(userPass.getPassword());
				
				
				if(LoginDAO.checkmemberPhone(phoneNum)) {
					new setPopup(new ImageIcon("ui/main/loginPopup/notmemberPhone.png"),300).setVisible(true);
					return;
				}
				
				if(LoginDAO.checkPhoneNum(phoneNum, password)) {
					parent.dispose();
				}
			}
		});
