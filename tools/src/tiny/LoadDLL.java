package tiny;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;
import tiny.LoadDLL.TestLoad.PDragonflyCallBack;

public class LoadDLL {

	public interface TestLoad extends Library { // cdecl call调用约定时为Library
		TestLoad INSTANCE = (TestLoad) Native.loadLibrary("E:\\workspace\\face\\DragonflyComm.dll", TestLoad.class);

		// < 打开指定的串口（当一个PC上有多个COM口的pid vid一样时调用此接口来指定串口号）
		int OpenSpecifiedCom(int iComNo);

		// < 打开串口同步发送，发送完毕后关闭串口
		// < 返回值：返回0成功，负数表示失败
		int Send2com(int tinyCmdType, String pData);

		// < 打开串口同步发送，并在指定超时时间内读取结果，返回时关闭串口
		// < 返回值：0成功，负数失败，正数表示读到的字节数
		int Send2comAndRead(int tinyCmdType, String pData, String pOutData, int iOutLen, int iOutTimeMillions);

		//异步发送和接受，串口会保持打开，因此调用下面的接口后就不要再调用上面的同步接口了
		//注册异步回调接收函数
		void SetDragonflyCallback(Callback pCbDragonfly);

		int AsyncSend2Com(int tinyCmdType, String pData);

		//回调函数实现
		public interface PDragonflyCallBack extends Callback {
			public void SetDragonflyCallback(int iCmdType, String pResult);
		}

	}

	public static class PDragonflyCallBackImpl implements PDragonflyCallBack {
		@Override
		public void SetDragonflyCallback(int iCmdType, String pResult) {
			System.out.println("------------" + iCmdType + "-----" + pResult);

		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int HANDSHAKE = 0,
			BARCODE = 1,
			PAY = 2,
			FACE = 3,
			SETTINGS = 4,
			CANCEL = 5,
			TINY_APP = 100,
			COMERR_MSG = 2019;

		//		 TODO Auto-generated method stub
		//		String pData = "{\"target\": \"QT\",\"content\": {\"bizNo\": \"123423\",\"totalAmount\": \"0.01\",\"from\":\"com.example.pos\",\"method\": \"start\"}}";
		String data2 = "{\"target\":\"ix\",\"content\":{\"command\":\"AppInfo\",\"commandLaunch\":\"APP\","
			+ "\"commandType\":\"NONEECHO\",\"random\":\"1476450135\",\"data\":{\"shopName\":\"JPOS测试9号\"}}}";
		//		TestLoad.INSTANCE.Send2com(TINY_APP, pData);

		TestLoad.PDragonflyCallBack pCbDragonfly = new PDragonflyCallBackImpl();
		TestLoad.INSTANCE.SetDragonflyCallback(pCbDragonfly);
		TestLoad.INSTANCE.AsyncSend2Com(TINY_APP, data2);

		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
