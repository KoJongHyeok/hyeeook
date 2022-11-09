
public class AudioPlayer extends Player {
//  ----------------------------------------------------------------------
//  >> 변수

//  ----------------------------------------------------------------------
//  >> 메서드
	
	@Override
	void play(int pos) {System.out.println(pos + "�ʺ��� ����Ͽ�.");}
	@Override
	void stop() {System.out.println("���߿�!");}
	
//  ----------------------------------------------------------------------
//  >> 생성자
	AudioPlayer() {super();}
	
}
