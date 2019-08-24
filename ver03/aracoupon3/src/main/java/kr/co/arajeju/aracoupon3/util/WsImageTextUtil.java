package kr.co.arajeju.aracoupon3.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.beryx.awt.color.ColorFactory;

/**
 * ref: https://wonsama.tistory.com/456
 * title: 텍스트 로고 이미지 자동 생성 JAVA 프로그램
 *
 * 입력 텍스트를 이미지로 만들어 준다
 * @author parkwon
 * @since 2017.03.24
 */
public class WsImageTextUtil {

	/**
	 * 테스트용 진입점
	 * @param args 파라미터
	 * @since 2017.03.24
	 */
	public static void main(String[] args) {
		try {
			new WsImageTextUtil();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 생성자
	 * @since 2017.03.24
	 */
	WsImageTextUtil() throws Exception {
		if (!Flag.flag) {
			// test 1
			this.drawText("어머니가 짜장면이 싫다고 하셨어", "/Users/kangmac/sample.png");
			// test 2
			//String[] texts = {"10,000", "아이폰 7 붉은색 사주세요"};
			//this.drawTextWithImage(texts
			//		, "/Users/kangmac/title.png"    // target image
			//		, "http://imgnews.naver.com/image/5463/2017/03/21/0000000101_003_20170322105216516.png"  // source image
			//		);
			String[] texts = {"(주)올띠쿠폰센타"};
			this.drawTextWithImage(texts
					, "/Users/kangmac/title.png"    // target image
					, "/Users/kangmac/title.png"    // target image
					);
		}

		if (Flag.flag) {
			DrawImageInfo drawImageInfo = new DrawImageInfo(
					//"/Users/kangmac/coupon_org_blue.png",  // inImgFileName
					//"/Users/kangmac/coupon_org_brown.png",  // inImgFileName
					//"/Users/kangmac/coupon_org_gold.png",  // inImgFileName
					//"/Users/kangmac/coupon_org_green.png",  // inImgFileName
					"/Users/kangmac/coupon_org_red.png",  // inImgFileName
					"/Users/kangmac/title.png",  // outImgFileName
					new DrawTextInfo[] {
							new DrawTextInfo("나눔고딕", 14, "white", 480, 40, false, "발행:(주)올띠쿠폰센타"),
							new DrawTextInfo("NanumGothicBold", 100, "white", 75, 220, true, "100,000원"),
							new DrawTextInfo("나눔고딕", 18, "yellow", 120, 340, false, "(주)올띠까페"),
							new DrawTextInfo("NanumGothic", 18, "yellow", 290, 340, false, "*사용기간: 2019.08.01 ~ 2019.12.31"),
							}
					);
			this.drawTextWithImage(drawImageInfo);
		}
	}

	/**
	 * 웹 이미지 내부에 텍스트를 포함하여 이미지로 만들어준다
	 * @param texts 텍스트 문자열
	 * @param fileLoc 파일위치
	 * @param backgrondImageURL 웹이미지 주소
	 * @throws Exception 오류
	 * @since 2017.03.27
	 */
	public void drawTextWithImage(DrawImageInfo drawImageInfo) throws Exception {
		BufferedImage img = ImageIO.read(new File(drawImageInfo.getInImgFileName()));

		DrawTextInfo[] drawTextInfos = drawImageInfo.getDrawTextInfos();

		Graphics g = img.getGraphics();
		for (int i=0; i < drawTextInfos.length; i++) {
			Graphics2D g2d = this.getG2D(img);
			Font font = new Font(drawTextInfos[i].getFontName(), Font.PLAIN, drawTextInfos[i].getFontSize());
			//Font font = new Font(drawTextInfos[i].getFontName(), Font.BOLD, drawTextInfos[i].getFontSize());
			g2d.setFont(font);

			int x = drawTextInfos[i].getPosX();
			int y = drawTextInfos[i].getPosY();

			if (drawTextInfos[i].isFlagShadow()) {
				// 그림자 처리
				g2d.setColor(new Color(20, 20, 20));  // shadow color
				g2d.drawString(drawTextInfos[i].getText(), shiftEast(x, 4), shiftSouth(y, 4));
			}

			// text
			g2d.setColor(ColorFactory.valueOf(drawTextInfos[i].getFontColor()));  // text color
			g2d.drawString(drawTextInfos[i].getText(), x, y);
		}
		g.dispose();

		// 이미지 파일을 생성한다
		ImageIO.write(img, "png", new File(drawImageInfo.getOutImgFileName()));
	}

	/**
	 * 텍스트를 이미지로 만들어준다
	 * @param text 텍스트
	 * @param fileLoc 파일위치
	 * @throws Exception 오류
	 * @since 2017.03.27
	 */
	public void drawText(String text, String fileLoc) throws Exception {
		Font font = new Font("나눔고딕", Font.PLAIN, 28);
		Rectangle r = this.getFontrect(text, font);
		int width = (int) r.getWidth();
		int height = (int) r.getHeight();

		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = this.getG2D(img);
		g2d.setFont(font);
		FontMetrics fm = g2d.getFontMetrics();
		g2d.setColor(Color.WHITE);
		g2d.drawString(text, 0, fm.getAscent());
		g2d.dispose();

		// 이미지 파일을 생성한다
		ImageIO.write(img, "png", new File(fileLoc));
	}

	/**
	 * 웹 이미지 내부에 텍스트를 포함하여 이미지로 만들어준다
	 * @param texts 텍스트 문자열
	 * @param fileLoc 파일위치
	 * @param backgrondImageURL 웹이미지 주소
	 * @throws Exception 오류
	 * @since 2017.03.27
	 */
	public void drawTextWithImage(String[] texts, String fileLoc, String backgrondImageURL) throws Exception {
		//final int FONT_SIZE = 18;
		//final int POS_X = 30;
		//final int POS_Y = 20;

		//final int FONT_SIZE = 64;
		//final int FONT_SIZE = 128;
		//final int POS_X = 120;
		//final int POS_Y = 230;

		final int FONT_SIZE = 24;
		final int POS_X = 120;
		final int POS_Y = 340;

		Font font = new Font("나눔고딕", Font.PLAIN, FONT_SIZE);
		//Rectangle rect = this.getFontrect(texts[0], font);

		//BufferedImage img = ImageIO.read(new URL(backgrondImageURL));
		//BufferedImage img = ImageIO.read(new File("/Users/kangmac/coupon_org_red_10000.png"));
		BufferedImage img = ImageIO.read(new File("/Users/kangmac/coupon_org_green.png"));
		//BufferedImage img = ImageIO.read(new File("/Users/kangmac/title.png"));
		Graphics g = img.getGraphics();
		int oriWidth = img.getWidth();
		int oriHeight = img.getHeight();

		//double ratio = (rect.getWidth() + POS_X*2) / oriWidth;

		//int newWidth = (int) (rect.getWidth() + POS_X*2);
		//int newHeight = (int) (oriHeight * ratio);

		// 배경 이미지 RESIZE 처리
		//img = this.resizeImage(img, newWidth, newHeight*texts.length);

		// 텍스트 처리
		for (int i=0; i < texts.length; i++) {
			Graphics2D g2d = this.getG2D(img);
			g2d.setFont(font);

			//int x = POS_X;
			//int y = (FONT_SIZE + POS_Y)*(i + 1);
			int x = POS_X;
			int y = POS_Y;

			// 그림자 처리
			this.drawStringDropshadow(g2d, texts[i], "yellow", x, y);
		}
		g.dispose();

		// 배경 이미지 CROP 처리
		//img = this.cropImage(img, new Rectangle(0, 0, newWidth, (FONT_SIZE+POS_Y)*texts.length+POS_Y) );
		img = this.cropImage(img, new Rectangle(0, 0, oriWidth, oriHeight ));

		// 이미지 파일을 생성한다
		ImageIO.write(img, "png", new File(fileLoc));
	}

	/**
	 * 입력받은 문자열의 사각영역을 반환한다
	 * @param text 문자열
	 * @param font 폰트
	 * @return 사각크기
	 * @since 2017.03.24
	 */
	private Rectangle getFontrect(String text, Font font){
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = img.createGraphics();
		g2d.setFont(font);
		FontMetrics fm = g2d.getFontMetrics();
		int width = fm.stringWidth(text);
		int height = fm.getHeight();
		g2d.dispose();

		return new Rectangle(0, 0, width, height);
	}

	/**
	 * 아웃라인 처리
	 * @param g2d 2D 그래픽스
	 * @param text 문자열
	 * @param x X좌표
	 * @param y Y좌표
	 * @param cin 내부 색상
	 * @param cout 외부 색상
	 * @since 2017.03.27
	 */
	@SuppressWarnings("unused")
	private void drawStringOutline(Graphics2D g2d, String text, int x, int y, Color cin, Color cout){
		g2d.setColor(cout);
		g2d.drawString(text, shiftWest(x, 1), this.shiftNorth(y, 1));
		g2d.drawString(text, shiftWest(x, 1), this.shiftSouth(y, 1));
		g2d.drawString(text, shiftEast(x, 1), this.shiftNorth(y, 1));
		g2d.drawString(text, shiftEast(x, 1), this.shiftSouth(y, 1));

		g2d.setColor(cin);
		g2d.drawString(text, x, y);
	}

	/**
	 * 그림자 텍스트를 그려준다
	 * @param g2d 2D 그래픽스
	 * @param text 문자열
	 * @param x X좌표
	 * @param y Y좌표
	 * @since 2017.03.27
	 */
	@SuppressWarnings("unused")
	private void drawStringDropshadow(Graphics2D g2d, String text, int x, int y) {
		g2d.setColor(new Color(20, 20, 20));  // shadow color
		g2d.drawString(text, shiftEast(x, 4), shiftSouth(y, 4));
		g2d.setColor(new Color(220, 220, 220));  // text color
		g2d.drawString(text, x, y);
	}

	private void drawStringDropshadow(Graphics2D g2d, String text, String color, int x, int y) {
		g2d.setColor(new Color(20, 20, 20));  // shadow color
		g2d.drawString(text, shiftEast(x, 4), shiftSouth(y, 4));
		g2d.setColor(ColorFactory.valueOf(color));  // text color
		g2d.drawString(text, x, y);
	}

	/**
	 * 폰트를 회전 처리한다
	 * @param font 폰트
	 * @param angle 회전각 0~360 / -를 넣으면 반시계 방향으로 계산
	 * @return 회전처리 된 폰트
	 * @since 2017.03.24
	 */
	@SuppressWarnings("unused")
	private Font rotatedFont(Font font, double angle){
		// 폰트 회전처리
		AffineTransform form = new AffineTransform();
		form.rotate(Math.toRadians(angle), 0, 0);
		return font.deriveFont(form);
	}

	/**
	 * 이미지 크롭처리
	 * @param img 이미지
	 * @param rect 사각정보
	 * @return 신규 이미지
	 * @since 2017.03.24
	 */
	private BufferedImage cropImage(BufferedImage img, Rectangle rect) {
		BufferedImage dest = img.getSubimage(rect.x, rect.y, rect.width, rect.height);
		return dest;
	}

	/**
	 * 이미지 리사이징
	 * @param img 이미지
	 * @param newW 새로운 넓이
	 * @param newH 새로운 높이
	 * @return 신규 이미지
	 * @since 2017.03.24
	 */
	@SuppressWarnings("unused")
	private BufferedImage resizeImage(BufferedImage img, int newW, int newH) {
		Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();

		return dimg;
	}

	/**
	 * 이미지에서 2D 그래픽스 개체를 얻어온다
	 * @param img 이미지버퍼
	 * @return 2D 그래픽스
	 * @since 2017.03.24
	 */
	private Graphics2D getG2D(BufferedImage img) {
		Graphics2D g2d = img.createGraphics();

		g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
		g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

		return g2d;
	}

	/**
	 * 좌표 이동처리 - 위쪽 / 북
	 * @param p 현 좌표
	 * @param distance 이동거리
	 * @return 변경된 좌표
	 * @since 2017.03.27
	 */
	int shiftNorth(int p, int distance) {
		return (p - distance);
	}

	/**
	 * 좌표 이동처리 - 아래쪽 / 남
	 * @param p 현 좌표
	 * @param distance 이동거리
	 * @return 변경된 좌표
	 * @since 2017.03.27
	 */
	int shiftSouth(int p, int distance) {
		return (p + distance);
	}

	/**
	 * 좌표 이동처리 - 오른쪽 / 동
	 * @param p 현 좌표
	 * @param distance 이동거리
	 * @return 변경된 좌표
	 * @since 2017.03.27
	 */
	int shiftEast(int p, int distance) {
		return (p + distance);
	}

	/**
	 * 좌표 이동처리 - 왼쪽 / 서
	 * @param p 현 좌표
	 * @param distance 이동거리
	 * @return 변경된 좌표
	 * @since 2017.03.27
	 */
	int shiftWest(int p, int distance) {
		return (p - distance);
	}
}

class DrawImageInfo {
	private String inImgFileName;
	private String outImgFileName;
	private DrawTextInfo[] drawTextInfos;
	////////////////////////////////////////////////////
	public DrawImageInfo(
			String inImgFileName,
			String outImgFileName,
			DrawTextInfo[] drawTextInfos) {
		this.inImgFileName = inImgFileName;
		this.outImgFileName = outImgFileName;
		this.drawTextInfos = drawTextInfos;
	}
	////////////////////////////////////////////////////
	public String getInImgFileName() {
		return inImgFileName;
	}
	public String getOutImgFileName() {
		return outImgFileName;
	}
	public DrawTextInfo[] getDrawTextInfos() {
		return drawTextInfos;
	}
}

class DrawTextInfo {
	private String  fontName;
	private int     fontSize;
	private String  fontColor;
	private int     posX;
	private int     posY;
	private boolean flagShadow;
	private String  text;
	////////////////////////////////////////////////////
	public DrawTextInfo(
			String fontName,
			int fontSize,
			String fontColor,
			int posX,
			int posY,
			boolean flagShadow,
			String text) {
		this.fontName = fontName;
		this.fontSize = fontSize;
		this.fontColor = fontColor;
		this.posX = posX;
		this.posY = posY;
		this.flagShadow = flagShadow;
		this.text = text;
	}
	////////////////////////////////////////////////////
	public String getFontName() {
		return fontName;
	}
	public int getFontSize() {
		return fontSize;
	}
	public String getFontColor() {
		return fontColor;
	}
	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}
	public boolean isFlagShadow() {
		return flagShadow;
	}
	public String getText() {
		return text;
	}
}
