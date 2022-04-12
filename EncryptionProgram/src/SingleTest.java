import java.util.ArrayList;
import java.util.Scanner;

public class SingleTest {
	public static char alphabetBoard[][] = new char[2][26];
	public static boolean oddFlag = false; //���ڼ� ���
	public static String zCheck ="";

	public static void main(String[] args) {
		String decryption; //��ȣ��
		String encryption; //��ȣ��
		
		Scanner sc = new Scanner(System.in); 	//�Է��� ���� Scanner ����
		System.out.print("��ȣȭ�� ���� Ű�� �Է��ϼ��� : ");
		String key = sc.nextLine();				//key �Է�
		System.out.print("��ȣȭ�� ���ڿ��� �Է��ϼ��� : ");
		String str =  sc.nextLine();				//���ڿ� �Է�(��)
		String blankCheck="";
		int blankCheckCount=0;

		setBoard(key);							//��ȣȭ�� ���� ��ȣ�� ����
		
		for( int i = 0 ; i < str.length() ; i++ ) 
		{
			if(str.charAt(i)==' ') //��������
			{
				str = str.substring(0,i)+str.substring(i+1,str.length());
				blankCheck+=10;
			}
			else
			{
				blankCheck+=0;
			}
			if(str.charAt(i)=='z') //z�� q�� �ٲ��༭ ó����.
			{
				str = str.substring(0,i)+'q'+str.substring(i+1,str.length());
				zCheck+=1;
			}
			else 
			{
				zCheck+=0;
			}
		}
		
		encryption = strEncryption(key, str); //��ȣȭ
		
		//��ºκ�
		System.out.println("��ȣȭ�� ���ڿ� : " + encryption);
	}

	
	
	private static String strEncryption(String key, String str){
		String encStr ="";
		
		for(int i=0; i<str.length(); i++) {
			for(int j=0; j<26; j++) {
				//System.out.println(alphabetBoard[0][j]);
				if(str.charAt(i) == alphabetBoard[0][j]) { //���� �������� �ν� ���ϰ� ���� => ��ҹ��� ����
					encStr += alphabetBoard[1][j];
					break;
				}
			}
			//System.out.println("----------");
		}
		return encStr;
	}

	private static void setBoard(String key) {
		String keyForSet = "";					// �ߺ��� ���ڰ� ���ŵ� ���ڿ��� ������ ���ڿ�.
		boolean duplicationFlag = false;		// ���� �ߺ��� üũ�ϱ� ���� flag ����.
		int keyLengthCount = 0;					// alphabetBoard�� keyForSet�� �ֱ� ���� count����.
		
		key += "abcdefghijklmnopqrstuvwxyz"; 	// Ű�� ��� ���ĺ��� �߰�.

				
		// �ߺ�ó��
		for( int i = 0 ; i < key.length() ; i++ ) 
		{
			for( int j = 0 ; j < keyForSet.length() ; j++ ) //���� ������
			{
				if(key.charAt(i)==keyForSet.charAt(j))
				{
					duplicationFlag = true;
					break;
				}
			}
			if(!(duplicationFlag)) keyForSet += key.charAt(i); //�ߺ��� ���ٸ�, �� ���ĺ� �߰�
			duplicationFlag = false; //�ٽ� false�� ��������
		}
		
		//�迭�� ����
		for( int i = 0 ; i < alphabetBoard[0].length; i++ )
		{
			alphabetBoard[0][i] = (char)(i + 'a');
			alphabetBoard[1][i] = keyForSet.charAt(keyLengthCount++);
		}
		
		//���
		for( int i = 0 ; i < alphabetBoard[0].length; i++ )
		{
			System.out.print(alphabetBoard[0][i]+"-");
		}		
		System.out.println();
		//���
		for( int i = 0 ; i < alphabetBoard[0].length; i++ )
		{
			System.out.print(alphabetBoard[1][i]+"-");
		}
		System.out.println();
	}

}