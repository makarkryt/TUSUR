///////////////////////////////////////////////////////////
//	Test.cpp
//
#define  STRICT
#define  WIN32_LEAN_AND_MEAN 
#include <Windows.h>

HWND g_hMain, g_hTemp, g_hChild;
BOOL g_bTopmost = FALSE;

LRESULT CALLBACK WndProc(HWND hWnd, UINT message, WPARAM wParam, LPARAM lParam);

int WINAPI  WinMain(
    _In_ HINSTANCE hInstance,
    _In_opt_ HINSTANCE,
    _In_ LPSTR,
    _In_ int nCmdShow
)
{

    LPCTSTR szClass = TEXT("Windowy45y8ywrfhshiarhfiwua43lass");

    WNDCLASS wc = { 0 };
    wc.lpfnWndProc = WndProc;
    wc.hInstance = hInstance;
    wc.lpszClassName = szClass;
    wc.hbrBackground = (HBRUSH)(COLOR_WINDOW + 1);

    ::RegisterClass(&wc);

    // Create Main window
    g_hMain = ::CreateWindow(szClass, TEXT("Main Window"), WS_OVERLAPPEDWINDOW,
        50, 50, 400, 250, NULL, NULL, hInstance, NULL);
    if (g_hMain == NULL) {
        return -1;
    }

    // Create Temp window
    g_hTemp = ::CreateWindow(szClass, TEXT("Temp Window"), WS_POPUP | WS_CAPTION | WS_SYSMENU | WS_THICKFRAME | WS_MINIMIZEBOX | WS_MAXIMIZEBOX | WS_VISIBLE,
        500, 50, 400, 250, NULL, NULL, hInstance, NULL);
    if (g_hTemp == NULL) {
        return -1;
    }

    // Create Child window
    g_hChild = ::CreateWindow(szClass, TEXT("Child Window"), WS_CHILD | WS_CAPTION | WS_SYSMENU | WS_THICKFRAME | WS_MINIMIZEBOX | WS_MAXIMIZEBOX | WS_VISIBLE,
        50, 50, 200, 150, g_hMain, NULL, hInstance, NULL);
    if (g_hChild == NULL) {
        return -1;
    }

    ::ShowWindow(g_hMain, nCmdShow);

    MSG msg;
    while (::GetMessage(&msg, NULL, 0, 0)) {
        ::DispatchMessage(&msg);
    }

    return 0;
}
//=========================================================

LRESULT CALLBACK WndProc(HWND hWnd, UINT message, WPARAM wParam, LPARAM lParam)
{
    switch (message) {

    case WM_LBUTTONDOWN:
        if (g_hChild == NULL || !::IsWindow(g_hChild)) {
            return 0;
        }
        else {
            ::SetParent(g_hChild, hWnd);
        }
        return 0;

    case WM_LBUTTONDBLCLK:
        if (hWnd == g_hTemp) {
            ::SetWindowPos(hWnd, !g_bTopmost ? HWND_TOPMOST : HWND_NOTOPMOST,
                0, 0, 0, 0, SWP_NOMOVE | SWP_NOSIZE);
        }
        return 0;

    case WM_DESTROY:
        if (hWnd == g_hMain) {
            ::PostQuitMessage(0);
        }
        return 0;
    }

    return ::DefWindowProc(hWnd, message, wParam, lParam);
}

//=========================================================
